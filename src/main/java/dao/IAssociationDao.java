package dao;

import entity.AssociationEntity;

import java.util.List;

/**
 * Created by Starry on 2017/12/11.
 */
public interface IAssociationDao {
    /*
        社团表中的college字段数值说明：
        中心校区----- 1
        洪家楼校区----2
        千佛山校区----3
        趵突泉校区----4
        软件园校区----5
        兴隆山校区----6
        青岛校区------7

        type字段说明：
        兴趣爱好-----1
        社会实践-----2
        科技创新-----3
        综合---------4
        其他---------5
     */


    /**
     * 查询所有社团
     * @return
     */
    List<AssociationEntity> getAll();

    /**
     * 通过id获取社团信息
     * @param id
     * @return
     */
    AssociationEntity searchById(long id);

    /**
     * 通过名称获取社团信息
     * @param name
     * @return
     */
     AssociationEntity getByName(String name);
    /**
     * 存储新社团
     * @param associationEntity
     * @return 新社团id
     */
    long insert(AssociationEntity associationEntity);

    /**
     * 查询社团
     * @param keyWord
     * @return
     */
    List<AssociationEntity> searchByName(String keyWord);

    /**
     * 通过校区获取社团列表
     * @param college
     * @return 某校区的社团列表
     */
    List<AssociationEntity> getByCollege(int college);

    /**
     * 通过类型返回社团列表
     * @param type
     * @return
     */
    List<AssociationEntity> getByType(String type);

    /**
     * 按照类型和校区返回社团列表
     * @param type
     * @param college
     * @return
     */
    List<AssociationEntity> getByTypeAndCollege(String type,int college);
    void updateAssociation(AssociationEntity associationEntity);
    void deleteAssociation(long id);
}
