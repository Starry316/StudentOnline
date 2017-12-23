package dao;

import entity.AssociationEntity;

/**
 * Created by Starry on 2017/12/11.
 */
public interface IAssociationDao {
    /**
     * 存储新社团
     * @param associationEntity
     * @return 新社团id
     */
    long insert(AssociationEntity associationEntity);
}
