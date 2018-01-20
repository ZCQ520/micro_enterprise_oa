package com.wzu.oa.common.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 创建人：yoan
 * 创建日期：17/8/24
 */
public class ListUtils extends org.apache.commons.collections.ListUtils {

    /**
     * 判断队列是否为空
     *
     * @param list
     * @return
     */
    public static boolean isEmptyList(List list) {
        return list == null || list.size() <= 0 ? true : false;
    }

    /**
     * 判断队列是否非空
     *
     * @param list
     * @return
     */
    public static boolean isNotEmptyList(List list) {
        return !isEmptyList(list);
    }

    /**
     * 将sourceList中某一个字段重新组装成另一个列表
     *
     * @param sourceList 目标列表
     * @param fieldName  目标字段
     * @param <T>        目标字段类型
     * @return
     */
    public static <S, T> List<T> getListFieldToList(List<S> sourceList, String fieldName) {
        if (sourceList != null && fieldName != null) {
            List<T> resultList = new ArrayList<>();
            try {
                for (S obj : sourceList) {
                    T t = (T) obj.getClass().getDeclaredMethod(BeanUtil.findGetter(fieldName), null).invoke(obj, null);
                    if (t != null) {
                        if (t instanceof List) {
                            //如果属性是一个列表，将所有列表项添加到结果列表
                            resultList.addAll((List<T>) t);
                        } else {
                            resultList.add(t);
                        }
                    }
                }
                return resultList;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 设置列表中某属性值
     * @param sourceList
     * @param fieldName
     * @param value
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> setListField(List<S> sourceList, String fieldName, Object value) {
        if (isNotEmptyList(sourceList) && !StringUtils.isEmpty(fieldName)) {
            List<T> resultList = new ArrayList<>();
            try {
                for (S obj : sourceList) {
                    T t = (T) obj.getClass().getDeclaredMethod(BeanUtil.findSetter(fieldName), value.getClass()).invoke(obj, value);
                    if (t != null) {
                        if (t instanceof List) {
                            //如果属性是一个列表，将所有列表项添加到结果列表
                            resultList.addAll((List<T>) t);
                        } else {
                            resultList.add(t);
                        }
                    }
                }
                return resultList;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
