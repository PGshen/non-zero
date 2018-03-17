package space.zero.core.service;

import com.google.common.collect.Lists;
import org.springframework.transaction.annotation.Transactional;
import space.zero.core.exception.ServiceException;
import space.zero.core.model.BaseEntity;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static space.zero.core.constant.Constant.*;

public abstract class AbstractDeleteFlagService<T extends BaseEntity> extends AbstractService<T> {

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractDeleteFlagService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Transactional(readOnly=false)
    @Override
    public T save(T model){
        model.setIsDelete(DELETE_FLAG_FALSE);
        model.setIsEnable(ENABLE_FLAG_TRUE);
        model.setUpdateTime(new Date());
        return super.save(model);
    }

    @Transactional(readOnly=false)
    public List<T> save(List<T> models){
        for (T model : models){
            this.save(model);
        }
        return models;
    }

    @Transactional(readOnly=false)
    @Override
    public void deleteById(String id){
        if (preDelete(id)) {
            T data = this.findById(id);
            if (data != null) {
                data.setIsDelete(DELETE_FLAG_TRUE);
                data.setUpdateTime(new Date());
                mapper.updateByPrimaryKey(data);
                afterDelete(data);
            }

        }
    }

    /**
     * 格式 : ids = 1,2,3...
     * @param ids
     */
    @Transactional(readOnly=false)
    public void deleteByIds(String ids){
        String[] id = ids.split(",");
        for (String i : id){
            this.deleteById(i);
        }
    }

    @Transactional(readOnly=false)
    public void delete(T data) {
        if (preDelete(data)) {
            data.setIsDelete(DELETE_FLAG_TRUE);
            data.setUpdateTime(new Date());
            mapper.updateByPrimaryKey(data);
            afterDelete(data);
        }
    }

    @Transactional(readOnly=false)
    @Override
    public T update(T data){
        data.setIsDelete(DELETE_FLAG_FALSE);
        data.setUpdateTime(new Date());
        return super.update(data);
    }

    @Transactional(readOnly=false)
    public void unDelete(T data) {
        data.setIsDelete(DELETE_FLAG_FALSE);
        data.setUpdateTime(new Date());
        mapper.updateByPrimaryKeySelective(data);
    }

    @Transactional(readOnly=false)
    public void unDeleteById(Object id) {
        T data = findById(String.valueOf(id));
        if (data != null) {
            data.setIsDelete(DELETE_FLAG_FALSE);
            data.setUpdateTime(new Date());
            mapper.updateByPrimaryKey(data);
        }
    }

    public T findById(String id) {
        String fieldName = "id";
        if (preGet(id)){
            T model = this.findBy(fieldName, id).get(0);
            afterGet(model);
            return model;
        }
        return null;
    }

    @Override
    public List<T> findBy(String fieldName, Object value) {
        if (preGet(fieldName)){
            try {
                T model = modelClass.newInstance();
                Field field = modelClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(model, value);
                Field deleteFlagField = modelClass.getDeclaredField("isDelete");
                deleteFlagField.setAccessible(true);
                deleteFlagField.set(model,DELETE_FLAG_FALSE);
                List<T> tList = mapper.select(model);
                for (T tmp : tList){
                    afterGet(tmp);
                }
                return tList;
            } catch (ReflectiveOperationException e) {
                throw new ServiceException(e.getMessage(), e);
            }
        }
        return null;
    }


    /**
     * 通过map获得查询条件
     * @param condition
     * @return
     */
    @Override
    public List<T> findBy(Map<String, Object> condition) {
        if (preGet(condition)){
            try {
                T model = modelClass.newInstance();
                for (Map.Entry<String, Object> cond : condition.entrySet()){
                    Field field = modelClass.getDeclaredField(cond.getKey());
                    field.setAccessible(true);
                    field.set(model, cond.getValue());
                }
                Field deleteFlagField = modelClass.getDeclaredField("isDelete");
                deleteFlagField.setAccessible(true);
                deleteFlagField.set(model,DELETE_FLAG_FALSE);
                List<T> tList = mapper.select(model);
                for (T tmp : tList){
                    afterGet(tmp);
                }
                return tList;
            } catch (ReflectiveOperationException e) {
                throw new ServiceException(e.getMessage(), e);
            }
        }
        return null;
    }


    /***
     * 通过model
     * @param
     * @return
     */
//    public List<T> findBy(T model){
//        if (preGet(model)){
//            model.setIsDelete(DELETE_FLAG_FALSE);
//            List<T> tList = mapper.select(model);
//            for (T tmp : tList){
//                afterGet(tmp);
//            }
//            return tList;
//        }
//        return null;
//    }

    @Override
    public List<T> findByIds(String ids) {
        if (preGet(ids)){
            List<T> tList = null;
            String[] id = ids.split(",");
            for (String i : id){
                T t = this.findById(i);
                if (t != null){
                    tList.add(t);
                }
            }
            return tList;
        }
        return null;
    }

    @Override
    public List<T> findByCondition(Condition condition) {
        if (preGet(condition)){
            condition.createCriteria().andCondition("is_delete = '0'");
            List<T> tList = mapper.selectByCondition(condition);
            for (T t : tList){
                afterGet(t);
            }
            return tList;
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        List<T> tList;
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField("isDelete");
            field.setAccessible(true);
            field.set(model, DELETE_FLAG_FALSE);
            tList = mapper.select(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        for (T t : tList){
            afterGet(t);
        }
        return tList;
    }

    /**
     * 批量插入或更新或删除，从数据库中查出旧的列表，将两个列表数据进行对比，然后分别进行插入更新和删除
     * 逐条修改,每一条都会触发其对应事件,大数据量慎用
     * @param oldList
     * @param newList
     * @return
     */
    @Transactional(readOnly=false)
    public Integer mergeList(List<T> oldList,List<T> newList){
        List<T> insertList= Lists.newArrayList();
        List<T> updateList=Lists.newArrayList();
        List<T> deleteList=Lists.newArrayList();

        //构建临时的hashmap
        HashMap<Object, T> tempOldMap=new HashMap<Object, T>(oldList.size());
        HashMap<Object, T> tempNewMap=new HashMap<Object, T>(newList.size());

        for(T oleItem:oldList){
            tempOldMap.put(getKey(oleItem), oleItem);
        }

        for(T newItem:newList){
            tempNewMap.put(getKey(newItem), newItem);
        }

        //找出需要更新和需要插入的的元素
        for(Object key:tempNewMap.keySet()){
            if(tempOldMap.containsKey(key)){
                updateList.add(tempNewMap.get(key));
            }else{
                insertList.add(tempNewMap.get(key));
            }
        }

        //找出需要删除的元素
        for(Object key:tempOldMap.keySet()){
            if(!tempNewMap.containsKey(key)){
                deleteList.add(tempOldMap.get(key));
            }
        }
        int changeCount=0;

        for(T item:insertList){
            save(item);
            changeCount+=1;
        }

        for(T item:updateList){
            update(item);
            changeCount+=1;
        }

        for(T item:deleteList){
            delete(item);
            changeCount+=1;
        }

        return changeCount;
    }

}
