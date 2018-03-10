package dao.impl;

import dao.IAssociationDao;
import entity.AssociationEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Starry on 2017/12/11.
 */
@Repository("associationDao")
public class AssociationDaoimpl extends BaseDaoimpl<AssociationEntity,Long> implements IAssociationDao{
    @Override
    @Transactional
    public long insert(AssociationEntity associationEntity) {
        return super.save(associationEntity);
    }

    @Override
    public List<AssociationEntity> getAll() {
        String hql="from AssociationEntity e";
        Query query=this.getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<AssociationEntity> searchByName(String keyWord) {
        String hql="from AssociationEntity e where e.associationName like '%"+keyWord+"%'";
        Query query=this.getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<AssociationEntity> getByCollege(int college) {
        String hql="from AssociationEntity e where e.college = "+college+"order by e.member";
        Query query=this.getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<AssociationEntity> getByType(String type) {
        String hql="from AssociationEntity e where e.type = "+type+"order by e.member";
        Query query=this.getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<AssociationEntity> getByTypeAndCollege(String type, int college) {
        String hql="from AssociationEntity e where e.type = "+type+"and e.college = "+college+"order by e.member";
        Query query=this.getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public AssociationEntity searchById(long id) {
        return super.get(id);
    }

    @Override
    public AssociationEntity getByName(String name) {
        String hql="from AssociationEntity e where e.associationName = \''"+name+"\'";
        Query query=this.getSession().createQuery(hql);
        List<AssociationEntity> list = query.list();
        if (list.size()==0)return null ;
        else return list.get(0);

    }

    @Override
    public void updateAssociation(AssociationEntity associationEntity) {
        super.update(associationEntity);
    }

    @Override
    public void deleteAssociation(long id) {
        super.delete(id);
    }
}
