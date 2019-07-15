package utills;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excellutills
{
	static FileInputStream fr;
	static XSSFWorkbook wb;
	public static Object[][] excel_data() throws Exception
	{
		fr=new FileInputStream("D:\\rakesh\\rakesh.xlsx");
		wb=new XSSFWorkbook(fr);
		XSSFSheet sheet=wb.getSheetAt(0);
		int row=sheet.getLastRowNum();
		int col=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
			data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
		
		
		
		
		
	}
}
