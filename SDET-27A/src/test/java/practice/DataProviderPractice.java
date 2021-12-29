package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider="getData")
	public void readDatafromdataprovider(String Name,String color,int qty)
	{
		
		System.out.println("mobile name---->"+Name+"-----mobile color--->"+color+"---mobile quantity"+qty);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr= new Object[5][3];
		
		objArr[0][0]="iphone";
		objArr[0][1]="black";
		objArr[0][2]=10;
		
		objArr[1][0]="samsung";
		objArr[1][1]="blue";
		objArr[1][2]=20;
		
		objArr[2][0]="oneplus";
		objArr[2][1]="lightblue";
		objArr[2][2]=30;
		
		objArr[3][0]="lenova";
		objArr[3][1]="gold";
		objArr[3][2]=40;
		
		objArr[4][0]="realme";
		objArr[4][1]="white";
		objArr[4][2]=50;
		
		return objArr;
		
	}

}
