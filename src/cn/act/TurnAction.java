package cn.act;

import java.util.ArrayList;

import cn.dao.TurnDao;
import cn.model.TurnOver;

public class TurnAction {
	TurnOver trunOver;
	ArrayList<TurnOver> list;
	//��ѯ���ʮ��Ӫҵ��
	public String turnQueryCurrent() {
		TurnDao turnDao = new TurnDao(); 
		list = turnDao.queryCurrentTurn();
		return "turnList";
	}
	
	public TurnOver getTrunOver() {
		return trunOver;
	}
	public void setTrunOver(TurnOver trunOver) {
		this.trunOver = trunOver;
	}
	public ArrayList<TurnOver> getList() {
		return list;
	}
	public void setList(ArrayList<TurnOver> list) {
		this.list = list;
	}
}
