package space.zero.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import space.zero.common.utils.ReflectionUtils;
import space.zero.core.exception.ServiceException;
import space.zero.core.mapper.Mapper;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Transactional(readOnly=false)
    public T save(T model) {
        if (preInsert(model)){
            mapper.insertSelective(model);
            afterInsert(model);
            return model;
        }
        return null;
    }

    @Transactional(readOnly=false)
    public List<T> save(List<T> models) {
        for (T model : models){
            if (preInsert(model)){
                mapper.insertSelective(model);
                afterInsert(model);
            }
        }
        return models;

    }

    @Transactional(readOnly=false)
    public void deleteById(String id) {
        if (preDelete(id)){
            mapper.deleteByPrimaryKey(id);
            afterDelete(id);
        }
    }

    @Transactional(readOnly=false)
    public void deleteByIds(String ids) {
        if (preDelete(ids)){
            mapper.deleteByIds(ids);
            afterDelete(ids);
        }
    }

    @Transactional(readOnly=false)
    public void delete(T data) {
        if (preDelete(data)) {
            mapper.deleteByPrimaryKey(data);
            afterDelete(data);
        }

    }

    @Transactional(readOnly=false)
    public T update(T model) {
        if (preUpdate(model)){
            mapper.updateByPrimaryKeySelective(model);
            afterUpdate(model);
            return model;
        }
        return null;
    }

    public T findById(String id) {
        if (preGet(id)){
            T model = mapper.selectByPrimaryKey(id);
            afterGet(model);
            return model;
        }
        return null;
    }

    @Override
    public List<T> findBy(String fieldName, Object value){
        if (preGet(fieldName)){
            try {
                T model = modelClass.newInstance();
                Field field = modelClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(model, value);
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

    public List<T> findByIds(String ids) {
        if (preGet(ids)){
            List<T> tList = mapper.selectByIds(ids);
            for (T t : tList){
                afterGet(t);
            }
            return tList;
        }
        return null;
    }

    public List<T> findByCondition(Condition condition) {
        if (preGet(condition)){
            List<T> tList = mapper.selectByCondition(condition);
            for (T t : tList){
                afterGet(t);
            }
            return tList;
        }
        return null;
    }

    public List<T> findAll() {
        List<T> tList = mapper.selectAll();
        for (T t : tList){
            afterGet(t);
        }
        return tList;
    }

    public Object getKey(T data){
        Object key=null;


        List<Field> idFields = ReflectionUtils.getFieldsByAnnotation(javax.persistence.Id.class, data);
        if(idFields!=null&&idFields.size()>0){
            if(idFields.size()==1){
                key= ReflectionUtils.invokeGetter(data, idFields.get(0).getName());
            }else{
                HashMap<String, Object> keyMap = new HashMap<String,Object>();
                for(Field item:idFields){
                    keyMap.put(item.getName(), ReflectionUtils.invokeGetter(data, item.getName()));
                }
                key=keyMap;
            }
        }else{
            key= ReflectionUtils.invokeGetter(data, "id");
        }
        return key;
    }

    @Override
    public boolean preGet(Object id) {
        return true;
    }

    @Override
    public void afterGet(T data) {

    }

    @Override
    public boolean preInsert(T data) {
        return true;
    }

    @Override
    public void afterInsert(T data) {

    }

    @Override
    public boolean preUpdate(T data) {
        return true;
    }

    @Override
    public void afterUpdate(T data) {

    }

    @Override
    public boolean preDelete(Object id) {
        return true;
    }

    @Override
    public void afterDelete(Object id) {

    }
}

