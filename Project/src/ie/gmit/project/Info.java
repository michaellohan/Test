package ie.gmit.project;

public class Info {
private String name;
private long time;
private long rowCount;
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the time
 */
public long getTime() {
	return time;
}
/**
 * @param time the time to set
 */
public void setTime(long time) {
	this.time = time;
}
/**
 * @return the rowCount
 */
public long getRowCount() {
	return rowCount;
}
/**
 * @param rowCount the rowCount to set
 */
public void setRowCount(long rowCount) {
	this.rowCount = rowCount;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Info [name=" + name + ", time=" + time + ", rowCount=" + rowCount
			+ "]";
}
/**
 * @param name
 * @param time
 * @param rowCount
 */
public Info(String name, long time, long rowCount) {
	super();
	this.name = name;
	this.time = time;
	this.rowCount = rowCount;
}
}
