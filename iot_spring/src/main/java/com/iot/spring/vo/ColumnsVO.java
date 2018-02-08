package com.iot.spring.vo;

public class ColumnsVO {
	private String columnName;
	private String columnDefault;
	private String isNullable;
	private String dataType;
	private Integer charMaxLength;
	private String columnType;
	private String columnKey;
	private String columnCommnet;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnDefault() {
		return columnDefault;
	}
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}
	public String getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	public String getColumnCommnet() {
		return columnCommnet;
	}
	public void setColumnCommnet(String columnCommnet) {
		this.columnCommnet = columnCommnet;
	}
	public Integer getCharMaxLength() {
		return charMaxLength;
	}
	public void setCharMaxLength(Integer charMaxLength) {
		this.charMaxLength = charMaxLength;
	}
	@Override
	public String toString() {
		return "ColumnsVO [columnName=" + columnName + ", columnDefault=" + columnDefault + ", isNullable=" + isNullable
				+ ", dataType=" + dataType + ", charMaxLength=" + charMaxLength + ", columnType=" + columnType
				+ ", columnKey=" + columnKey + ", columnCommnet=" + columnCommnet + "]";
	}
	
	
	
	
	
	
	
}
