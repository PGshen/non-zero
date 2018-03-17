package space.zero.core.service;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Map;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T> {
    T save(T model);//持久化
    List<T> save(List<T> models);//批量持久化
    void deleteById(String id);//通过主鍵刪除
    void deleteByIds(String ids);//批量刪除 eg：ids -> “1,2,3,4”
    T update(T model);//更新
    T findById(String id);//通过ID查找
    List<T> findBy(String fieldName, Object value); //通过Model中某个成员变量名称（非数据表中column的名称）查找
    List<T> findBy(Map<String, Object> cond);//通过map
//    List<T> findBy(T cond);
    List<T> findByIds(String ids);//通过多个ID查找//eg：ids -> “1,2,3,4”
    List<T> findByCondition(Condition condition);//根据条件查找
    List<T> findAll();//获取所有
    /**
     * 根据主键获取数据回调，该方法返回false则不进行查询直接返回null
     * @param id
     * @return
     */
    boolean preGet(Object id);

    void afterGet(T data);

    boolean preInsert(T data);

    void afterInsert(T data);

    boolean preUpdate(T data);

    void afterUpdate(T data);

    boolean preDelete(Object id);

    void afterDelete(Object id);
}

