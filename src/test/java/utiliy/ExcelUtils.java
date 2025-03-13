package utiliy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ExcelUtils {
	private Workbook workbook;
	private Sheet sheet;

	public ExcelUtils(String filepath,String sheetName) throws IOException{
		FileInputStream file=new FileInputStream(new File(filepath));
		this.workbook=new XSSFWorkbook(file);
		this.sheet=workbook.getSheet(sheetName);

	}
	//get the number of rows in the sheet
	public int getRowCount()
	{
		return sheet.getPhysicalNumberOfRows();
	}
	//get the value from a specific cell(rowIndex,columnIndex)
	public String getCellData(int rowIndex,int colIndex)
	{
		Row row=sheet.getRow(rowIndex);
		if(row!=null)
		{
			org.apache.poi.ss.usermodel.Cell cell=row.getCell(colIndex);
			if(cell!=null)
			{
				return cell.toString();
			}
		}
		return "";

	}

	//get the value from specific cell using column name(assuming the first row contains column names)
	public String getCellDataByColumnName(int rowIndex,int columnnName)
	{
		Row headerRow=sheet.getRow(0);
		Iterator<org.apache.poi.ss.usermodel.Cell> cells=headerRow.cellIterator();
		int columnIndex=-1;
		//find the column index for the given column name
		while(cells.hasNext())
		{
			org.apache.poi.ss.usermodel.Cell cell=cells.next();
			if(cell.toString().equals(columnnName))
			{
				columnIndex=cell.getColumnIndex();
				break;
			}
		}
		return getCellData(rowIndex, columnIndex);
	}

	//close the workwork after usage
	public void close() throws IOException
	{
		workbook.close();
	}



}
