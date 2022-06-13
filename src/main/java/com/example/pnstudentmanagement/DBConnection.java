package com.example.pnstudentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    Connection connection;

    DBConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/products", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connect success");
    }

    List<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            ResultSet result = connection.prepareStatement("SELECT * from product").executeQuery();
            while (result.next()) {
                int id = result.getInt("id_product");
                String name = result.getString("name_product");
                String  img = result.getString("image_product");
                String price = result.getString("price_product");
                System.out.println("=====");
                System.out.println(id);
                System.out.println(name);
                System.out.println(img);
                System.out.println(price);

                products.add(new Product(id, name,img,price));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
    void insertProduct(Product product) {
        String sql = "INSERT INTO product (name_product,image_product,price_product) VALUES ('" + product.name + "','" + product.img + "','" + product.price + "')";
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void updateStudent(Product product) {
        String sql = "UPDATE product SET name_product='"+product.name+"',image_product='"+product.img+"',price_product="+product.price+" WHERE id_product="+product.id;
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void deleteStudent(int id){
        String sql = "Delete from product where id_product="+id;
        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
