package com.deepsingh44.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.deepsingh44.model.Product;
import com.deepsingh44.model.User;

public class ProductDao {

	private static ProductDao productDao = new ProductDao();

	private ProductDao() {
	}

	public static ProductDao getProductDao() {
		return productDao;
	}

	public int insert(Product product) {
		int i = 0;
		try (Connection con = Dao.getConnection();) {
			PreparedStatement ps = con.prepareStatement("insert into product values(default,?,?,?,?,?)");
			ps.setString(1, product.getName());
			ps.setFloat(2, product.getPrice());
			ps.setInt(3, product.getQuantity());
			ps.setString(4, product.getCategory());
			ps.setString(5, product.getDate());
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public List<Product> getAllProductsOrderByDesc() {
		List<Product> list = new ArrayList<>();
		try (Connection con = Dao.getConnection();) {
			PreparedStatement ps = con.prepareStatement("select * from product order by dates desc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				p.setQuantity(rs.getInt(4));
				p.setCategory(rs.getString(5));
				p.setDate(rs.getString(6));
				list.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
