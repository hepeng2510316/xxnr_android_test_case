package com.example.yu.test.test.RunTestCase;

import java.util.ArrayList;

import com.example.yu.test.test.RunTestCase.*;

import android.text.AndroidCharacter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Casetest extends BaseCase {
	public String tag = "Casetest";

	public void test_run() {
		t("�ҵ�");
		t("��ũ����");
		t("�ͻ��Ǽ�");
		ArrayList<android.widget.ImageView> l = solo
				.getCurrentViews(android.widget.ImageView.class);
		showLog(l.size()+"");
	}
}