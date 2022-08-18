/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtk.repository.impl;

import com.vtk.pojo.Category;
import com.vtk.pojo.OrderDetail;
import com.vtk.pojo.Product;
import com.vtk.pojo.SaleOrder;
import com.vtk.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kien
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    /**
     *
     * @param params
     * @param page
     * @return
     */
    @Override
    public List<Product> getProducts(Map<String, String> params, int page) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root root = query.from(Product.class);
        query.select(root);
        if (params != null) {
            List<Predicate> listPredicates = new ArrayList<>();

            if (params.containsKey("kw") == true) {
                listPredicates.add(builder.like(root.get("name").as(String.class),
                        String.format("%%%s%%", params.get("kw"))));
            }
            
            if(params.containsKey("cateId") == true){
                int cateId = Integer.parseInt(params.get("cateId"));
                listPredicates.add(builder.equal(root.get("categoryId"), cateId));
            }
            
            query = query.where(listPredicates.toArray(Predicate[]::new));
        }

        query = query.orderBy(builder.desc(root.get("id")));

        Query q = session.createQuery(query);

        if (page != 0) {
            int max = 9;
            q.setMaxResults(max);
            q.setFirstResult((page - 1) * max);
        }

        return q.getResultList();
    }

    @Override
    public Product getProductById(int productId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(Product.class, productId);
    }
    
    @Override
    public List<Product> getProducts(){
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("From Product");
        
        return q.getResultList();
    }

    @Override
    public List<Object> countProdByCate() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = b.createQuery(Object.class);
        Root cRoot = query.from(Category.class);
        Root pRoot = query.from(Product.class);
        
        query.where(b.equal(pRoot.get("categoryId"), cRoot.get("id")));
        query.multiselect(cRoot.get("id"), cRoot.get("name"), b.count(pRoot.get("id")));
        query.groupBy(cRoot.get("id"));
        //, b.count(cRoot.get("productSet"))
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Object> renueve(int quarter, int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = b.createQuery(Object.class);
        
        Root rP = query.from(Product.class);
        Root rD = query.from(OrderDetail.class);
        Root rO = query.from(SaleOrder.class);
        
        query.where(b.equal(rD.get("productId"), rP.get("id")), 
                b.equal(rD.get("orderId"), rO.get("id")),
                b.equal(b.function("QUARTER", Integer.class, rO.get("createdDate")), quarter),
                b.equal(b.function("YEAR", Integer.class, rO.get("createdDate")), year));
        
        
        query.multiselect(rP.get("id"), rP.get("name"), b.sum(b.prod(rD.get("num"), rD.get("unitPrice"))));
        query.groupBy(rP.get("id"));
        //, b.count(cRoot.get("productSet"))
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean addProduct(Product p) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try{
            session.save(p);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int productId) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
         
         try{
            Product p = session.get(Product.class, productId);
            session.delete(p);
            return true;
         }catch(Exception ex){
            ex.printStackTrace();
            return false;
         }
    }

    @Override
    public boolean checkProductName(String value) {
        return false;
    }
}
