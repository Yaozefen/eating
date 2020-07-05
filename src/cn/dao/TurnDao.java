package cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.model.TurnOver;

public class TurnDao extends BaseDao{
	public ArrayList<TurnOver> queryCurrentTurn() {

		ArrayList<TurnOver> list = new ArrayList<TurnOver>();
		String sql = "select * from turnoverTable  where date_sub(CURDATE(),INTERVAL 10 DAY) <= DATE(date) order by date asc;";
		this.conn = this.getConn();
		this.stmt = this.getStmt();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs != null && rs.next()) {
				TurnOver turnOver = new TurnOver();
				turnOver.setDate(rs.getString("date"));
				turnOver.setTurn(rs.getInt("turnover"));
				list.add(turnOver);
			}
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
