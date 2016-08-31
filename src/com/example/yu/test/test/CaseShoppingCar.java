package com.example.yu.test.test;

import java.util.ArrayList;

import android.view.View;
import android.widget.TextView;

import com.example.yu.test.test.RunTestCase.*;
import com.robotium.solo.Solo;

public class CaseShoppingCar extends BaseCase {

	String tag = "CaseShoppingCar";

	public static CaseShoppingCar caseInstance(Solo solo1) {
		CaseShoppingCar instance = new CaseShoppingCar();
		instance.instance(solo1);
		return instance;
	}
	
	public void test_run() {
		shoppingCar_jump();
		shoppingCar_number();
		shoppingCar_delete();
		toClearing() ;
	}


	// �����ﳵ�������Ʒ�����ع��ﳵ
	public void add() {
		t("��ҳ");
		t("����ר��");
		solo.clickInList(1);
		s();
		t("���빺�ﳵ");
		t("1.5L �ֶ���MT��");
		t("������");
		t("�ſ��");
		t("ȷ��");
		t("���빺�ﳵ");
		t("������");
		t("ȷ��");
		t("���빺�ﳵ");
		t("���ƺ�");
		t("ȷ��");
		t("���빺�ﳵ");
		t("���Ű�");
		t("ȷ��");
		g();
		solo.clickInList(2);
		t("���빺�ﳵ");
		t("ȷ��");
		g();
		g();
		t("����ר��");
		solo.clickInList(2);
		t("���빺�ﳵ");
		t("ȷ��");
		v("com.ksfc.newfarmer:id/title_right_img");
	}

	/**
	 * ���ﳵҳ�����ת
	 */
	public void shoppingCar_jump() {

		// ��֤���ﳵΪ��
		t("���ﳵ");
		if (!solo.searchText("ȥ�򻯷�",1,false,true)) {
			t("�༭");
			v("com.ksfc.newfarmer:id/btn_check_all");
			v("com.ksfc.newfarmer:id/ordering_go_bt");
			solo.clickOnButton("��");
		}
		t("��ҳ");
		solo.assertCurrentActivity(tag + ":shoppingCar_jump():��ҳ",
				"HomepageActivity");
		t("���ﳵ");
		t("��Ѷ");
		solo.assertCurrentActivity(tag + ":shoppingCar_jump():��Ѷ",
				"NewFarmerInfomationActivity");
		t("���ﳵ");
		t("�ҵ�");
		solo.assertCurrentActivity(tag + ":shoppingCar_jump():�ҵ�",
				"MineActivity");
		t("���ﳵ");
		t("ȥ�򻯷�");
		solo.assertCurrentActivity(tag + ":shoppingCar_jump():����ר��",
				"GoodsListActivity");
		g();
		t("ȥ������");
		solo.assertCurrentActivity(tag + ":shoppingCar_jump():����ר��",
				"GoodsListActivity");
		g();
	}

	/**
	 * �޸���Ʒ���� (������Ҫ�϶����Ʒ������Ʒ������ʱ�޷�ͨ�����������ȷѡ��������add()д���˼��빺�ﳵ����Ʒ��������)
	 */
	public void shoppingCar_number() {
		// ���ﳵ�����д������Ʒ
		add();

		// ��Ʒ�������޸�
		// ͨ����+-�����޸���Ʒ����
		for (int a = 0; a < 4; a++) {
			v("com.ksfc.newfarmer:id/ordering_item_jia1");
		}
		for (int b = 0; b < 4; b++) {
			v("com.ksfc.newfarmer:id/ordering_item_jian1");
		}

		// ����Ʒ����ɾ��
		v("com.ksfc.newfarmer:id/ordering_item_geshu");
		clear("com.ksfc.newfarmer:id/dialog_item_geshu");
		t("ȷ��");
/**		if (!solo.waitForText("��������ȷ����Ʒ������")) {
 *			showErrLog(tag + ":shoppingCar_number():����Ʒ����ɾ��");
 *		}
*/
		// ����Ʒ������Ϊ0
		clear("com.ksfc.newfarmer:id/dialog_item_geshu");
		enter("com.ksfc.newfarmer:id/dialog_item_geshu", "0");
		t("ȷ��");
/**		if (!solo.searchText("��������ȷ����Ʒ������")) {
 *			showErrLog(tag + ":shoppingCar_number():����Ʒ������Ϊ0");
 *		}
 */
		// �����������ȷ����Ʒ����
		int x = 1 + (int) (Math.random() * 9999);
		String number = x + "";
		clear("com.ksfc.newfarmer:id/dialog_item_geshu");
		enter("com.ksfc.newfarmer:id/dialog_item_geshu", number);
		t("ȷ��");
		TextView tv = (TextView) solo
				.getView("com.ksfc.newfarmer:id/ordering_item_geshu");
		String s = (String) tv.getText();
		int a = Integer.parseInt(s);
		if (a != x) {
			showErrLog(tag + ":shoppingCar_number():�����ּ���������ȷ����Ʒ����");
		}

		// ��Ʒ����Ϊ1ʱ�����������
		v("com.ksfc.newfarmer:id/ordering_item_geshu");
		clear("com.ksfc.newfarmer:id/dialog_item_geshu");
		enter("com.ksfc.newfarmer:id/dialog_item_geshu", "1");
		t("ȷ��");
		v("ordering_item_jian1");
		if (!solo.waitForText("��Ʒ�����ټ�����Ŷ")) {
			showErrLog(tag + ":shoppingCar_number(): ��Ʒ����Ϊ1ʱ�����������");
		}

		// ��Ʒ����Ϊ9999ʱ��������
		v("com.ksfc.newfarmer:id/ordering_item_geshu");
		clear("com.ksfc.newfarmer:id/dialog_item_geshu");
		enter("com.ksfc.newfarmer:id/dialog_item_geshu", "9999");
		t("ȷ��");
		v("ordering_item_jia1");
		if (!solo.waitForText("��Ʒ�������ܴ���9999")) {
			showErrLog(tag + ":shoppingCar_number():��Ʒ����Ϊ9999ʱ��������");
		}
	}

	/**
	 * ɾ����Ʒ
	 */
	public void shoppingCar_delete() {
		// ���󻬶�ɾ��ĳ����Ʒ
		if (solo.searchText("���", 1, false, true)) {
			t("���");
		}
		View view = solo.getView("com.ksfc.newfarmer:id/ordering_item_img");
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		if (!solo.searchText("ɾ��", 1, false, true)) {
			showErrLog(tag + ":shoppingCar_delete():���󻬶�ɾ��ĳ����Ʒ");
		}
		t("ɾ��");
		t("��");

		// ͨ���༭����ɾ����Ʒ
		// ͨ��ȡ��ȫѡ����û��ѡ���κ���Ʒ�������ɾ��
		t("�༭");
		ArrayList<android.widget.CheckBox> checkBox = solo
				.getCurrentViews(android.widget.CheckBox.class);
		int a = (checkBox.size() - 1);
		if (solo.isCheckBoxChecked(0)) {
			solo.clickOnCheckBox(0);
		}
		solo.clickOnCheckBox(a);
		solo.clickOnCheckBox(a);
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if (!solo.waitForText("��������ѡ��һ����Ʒ")) {
			showErrLog(tag + ":shoppingCar_delete():ͨ��ȡ��ȫѡ����û��ѡ���κ���Ʒ�������ɾ��");
		}

		// ���ѡ��ɾ��������Ʒ
		int x = (int) (Math.random() * a);
		solo.clickOnView(checkBox.get(x));
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		t("��");
		t("��ҳ");
	}

	/**
	 * ���ﳵҳ���ȥ�������
	 */

	public void toClearing() {
		logout();
		t("���ﳵ");
		// �жϹ��ﳵ�ڻ���û����Ʒû�������
		if (solo.searchText("ȥ�򻯷�", 1, false, true)) {
			add();
		} else {
			t("���");
		}

		// δ��¼��δѡ���κ���Ʒ�������ѡ��ȥ����
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":toClearing():δ��¼�����ѡ����Ʒȥ����",
				"LoginActivity");
		g();

		// δ��¼�����ѡ����Ʒȥ����
		solo.clickOnCheckBox(0);
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":toClearing():δ��¼�����ѡ����Ʒȥ����",
				"LoginActivity");
		// ��¼�����δѡ���κ���Ʒȥ����
		clear("com.ksfc.newfarmer:id/login_layout_phone");
		enter(("com.ksfc.newfarmer:id/login_layout_phone"), Config.pNum_reg);//
		enter(("com.ksfc.newfarmer:id/login_layoutpassword"), Config.pwd_cur);
		t("ȷ�ϵ�¼");
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		if (!solo.waitForText("��������ѡ��һ����Ʒ")) {
			showErrLog(tag + ":shoppingCar_delete():��¼�����δѡ���κ���Ʒȥ����");
		}

		// ��½��ѡ��һ����Ʒȥ����
		if (solo.searchText("ȥ�򻯷�", 1, false, true)) {
			add();
		}
		ArrayList<android.widget.CheckBox> checkBox2 = solo
				.getCurrentViews(android.widget.CheckBox.class);
		int a = (checkBox2.size() - 1);
		solo.clickOnView(checkBox2.get(1));
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":toClearing():��½��ѡ��һ����Ʒȥ����",
				"AddOrderActivity");
		g();

		// ��½��ѡ��ȫ����Ʒȥ����
		solo.clickOnView(checkBox2.get(a));
		v("com.ksfc.newfarmer:id/ordering_go_bt");
		solo.assertCurrentActivity(tag + ":toClearing():��½��ѡ��ȫ����Ʒȥ����",
				"AddOrderActivity");
		
	}

}
