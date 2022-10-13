package Utility;

public interface ExcelUtility {
	public String readStringDataFromExcel(int sheetNo, int rowNo, int colNo);
	public double readIntegerDataFromExcel(int sheetNo, int rowNo, int colNo);
}
