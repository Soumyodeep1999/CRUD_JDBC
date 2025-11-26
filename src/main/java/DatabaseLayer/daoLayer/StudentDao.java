package DatabaseLayer.daoLayer;

import DatabaseLayer.connector.ConnectDatabase;
import DatabaseLayer.queryRepo.QueryRepo;
import EntityLayer.Student;
import com.google.protobuf.Internal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentDao {



    public PreparedStatement prepareStatement(String query){
        try {
            return ConnectDatabase.connect().prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addStudentData(Student student){
        try {
            PreparedStatement statement = prepareStatement(QueryRepo.addStudentQuery);
            statement.setInt(1,student.getSid());
            statement.setString(2,student.getSname());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteStudentData(int sid){
        try {
            PreparedStatement statement = prepareStatement(QueryRepo.deleteStudentQuery);
            statement.setInt(1,sid);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List retriveStudentData(){
        try {
            PreparedStatement statement = prepareStatement(QueryRepo.viewStudentDataQuery);
            ResultSet resultSet = statement.executeQuery();
            List studentList = new ArrayList<HashMap<Integer,String>>();
            while(resultSet.next()){
                HashMap student = new HashMap<Integer,String>();
                student.put("id",resultSet.getInt(1));
                student.put("name",resultSet.getString(2));
                studentList.add(student);
            }
            statement.close();
            return studentList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudentData(Student student){
        try {
            PreparedStatement statement = prepareStatement(QueryRepo.updateStudentDataQuery);
            statement.setInt(2,student.getSid());
            statement.setString(1,student.getSname());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
