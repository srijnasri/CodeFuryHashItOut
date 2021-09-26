package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	@Override
	public List<Product> findAllProducts(int userid) {
		try {
			PreparedStatement pgetAllProd;
			Connection con = DBUtil.getMyConnection();
			List<Product> plist = new ArrayList<>();
			pgetAllProd = con.prepareStatement(
					"select name,quantity,cid,actualPrice,description,image from Product where sellerid = ?");
			pgetAllProd.setInt(1, userid);
			ResultSet rs = pgetAllProd.executeQuery();
			while (rs.next()) {
				plist.add(new Product(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
			return plist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(Product p) {
		Connection con = DBUtil.getMyConnection();
		try {
			PreparedStatement inspr;
			inspr = con.prepareStatement(
					"insert into Product(name,quantity,sellerid,cid,actualPrice,description,image) values(?,?,?,?,?,?,?)");
			inspr.setString(1, p.getName());
			inspr.setInt(4, p.getCid());
			inspr.setString(6, p.getDescription());
			inspr.setDouble(5, p.getActualPrice());
			inspr.setInt(2, p.getQuantity());
			inspr.setString(7, p.getImage());
			inspr.setInt(3, p.getSellerID());

			int num = inspr.executeUpdate();

			if (num > 0) {
				con.commit();
			}
		}
			catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}
}
