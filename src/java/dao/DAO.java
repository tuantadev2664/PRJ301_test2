/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Category;
import model.Product;

/**
 *
 * @author FPTSHOP
 */
public class DAO {
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        String sql = "select * from product";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), 
                        rs.getString(2), 
                       rs.getString(3), 
                       rs.getDouble(4), 
                     rs.getString(5), 
                      rs.getString(6)));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return list;
    }
    
    public List<Product> getAllProductByCategoryID(String cid){
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where cateid = ?";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), 
                        rs.getString(2), 
                       rs.getString(3), 
                       rs.getDouble(4), 
                     rs.getString(5), 
                      rs.getString(6)));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return list;
    }
    
    public List<Product> getAllProductBySellID(String sellid){
        List<Product> list = new ArrayList<>();
        String sql = "select * from product\n" +
"  where sell_ID = ?";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sellid);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), 
                        rs.getString(2), 
                       rs.getString(3), 
                       rs.getDouble(4), 
                     rs.getString(5), 
                      rs.getString(6)));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return list;
    }
    
    public List<Product> searchProduct(String str){
        List<Product> list = new ArrayList<>();
        String sql = "select * from product where description like ? ";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + str + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), 
                        rs.getString(2), 
                       rs.getString(3), 
                       rs.getDouble(4), 
                     rs.getString(5), 
                      rs.getString(6)));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return list;
    }
    
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Category(rs.getInt(1), 
                        rs.getString(2)
                     ));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return list;
    }
    
    public Product getLast(){
        String sql = "select top 1 * from product order by id desc";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Product(rs.getInt(1), 
                        rs.getString(2), 
                       rs.getString(3), 
                       rs.getDouble(4), 
                     rs.getString(5), 
                      rs.getString(6));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return null;
    }
    
    public Product getProductByID(String id){
        String sql = "select * from product where id = ?";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Product(rs.getInt(1), 
                        rs.getString(2), 
                       rs.getString(3), 
                       rs.getDouble(4), 
                     rs.getString(5), 
                      rs.getString(6));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return null;
    }
    
    public Account login(String user, String pass){
        String sql = "select * from account\n" +
"where [user] = ?\n" +
"and pass = ?";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Account(rs.getInt(1), 
                        rs.getString(2), 
                       rs.getString(3), 
                       rs.getInt(4), 
                     rs.getInt(5)
                      );
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return null;
    }
    
    public Account checkAcoountExist(String user){
        String sql = "select * from account\n" +
"where [user] = ?\n";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Account(rs.getInt(1), 
                        rs.getString(2), 
                       rs.getString(3), 
                       rs.getInt(4), 
                     rs.getInt(5)
                      );
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return null;
    }
    
    public void signUp(String user, String pass){
        String sql = "insert into account values(?, ?,0, 0)";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    
    public void deleteProduct(String pid){
        String sql = "delete from product\n" +
"  where id = ?";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pid);
            st.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    
    public void insertProduct(String nameString, String imageString, String price,  String titleString, String descriptionString, String category, int sellid){
        String sql = " INSERT [dbo].[product] ( [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (?,?,?,?,?,?,?)";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, nameString);
            st.setString(2, imageString);
            st.setString(3,price);
            st.setString(4, titleString);
            st.setString(5, descriptionString);
            st.setString(6, category);
            st.setInt(7, sellid);
            st.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    
    public void editProduct(String name, String image, String price,
            String title, String description, String category, String pid) {
        String sql = "update product\n"
                + "set [name] = ?,\n"
                + "[image] = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "[description] = ?,\n"
                + "cateID = ?\n"
                + "where id = ?";
        
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.setString(3, price);
            st.setString(4, title);
            st.setString(5, description);
            st.setString(6, category);
            st.setString(7, pid);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        DAO dao  = new DAO();
//        for(Product product : dao.getProductByID("1"))
//            System.out.println(product);
System.out.println(dao.login("Adam", "123456"));
    }
}
