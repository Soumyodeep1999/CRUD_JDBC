package DatabaseLayer.queryRepo;

public class QueryRepo {

    private static String tableName = "student";
    public static String addStudentQuery = "insert into "+tableName+" (sid,sname) values (?,?)";
    public static String deleteStudentQuery = "delete from "+tableName+" where sid=?";
    public static String viewStudentDataQuery = "select * from "+tableName;
    public static String updateStudentDataQuery = "update "+tableName+" set sname=? where sid=?";

}
