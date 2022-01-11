package com.hustar.recipe;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ReadJsonFileToJsonObject {
	public static void main(String[] args) throws FileNotFoundException {
// FileReader ����
		Reader reader = new FileReader("C:\\Users\\HUSTAR11\\Documents\\lecture.json");
// Json ���� �о, Lecture ��ü�� ��ȯ
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
// JsonObject ��ü ���
// {"id":1,"students":[{"id":123,"name":"Tom"},{"id":124,"name":"Jerry"}],"subject":{"name":"Java","professor":"Anna"}}
		System.out.println(obj);
	}
}
