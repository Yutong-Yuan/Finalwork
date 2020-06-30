package NoteBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class note {
    static ArrayList<String> Content_list = new ArrayList<>();
    static ArrayList<String> Status_list = new ArrayList<>();
    static note note = new note();
    public static void main(String[] args) {


        while(true){
            note.menu();
            int choice;
            choice=note.InputInt();
            if(choice==1) {
                System.out.print("请输入你想记录的待办事项：");
                String string2 = InputString();
                note.Add(string2);
            }
            else if(choice==2){
                note.printnt();
                System.out.print("选择你想删除的事项：");
                int input=note.InputInt();
                note.Delete(input);
            }
            else if(choice==3){
                note.printnt();
                int choose;
                System.out.print("选择你想修改的事项：");
                int input=note.InputInt();
                System.out.print("选择你想修改的状态T/F(0表示F，1表示T)：");
                choose=note.InputInt();
                if(choose==1) note.Change_status(input, true);
                else if(choose==0) note.Change_status(input, false);
            }
            else if(choice==4){
                note.printnt();
            }
            else if(choice==5) {
                System.out.print("--------Wecome!--------");
                break;
            }


        }



    }
    //状态面板
    public  void menu(){
        System.out.print("--------NoteBook--------\n");

        System.out.println("1.添加待办事项\n2.删除待办事项\n3.改变待办事项的状态\n4.查询当前待办事项记录\n5.退出");
        System.out.print("请选择：");
    }


    public static String InputString() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }



    //选择添加，删除，修改和退出功能--返回int
    public  int InputInt() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        return x;
    }
    //删除待办事项--返回boolean
    public  boolean Delete(int index) {
        try{
            System.out.print("删除事项：");
            System.out.print(Content_list.get(index-1));
            Content_list.remove(index-1);
            Status_list.remove(index-1);
        }catch(Exception e){
            System.out.print("当前无可删事项\n");
            return false;
        }
        return true;
    }
    //输入待办事项--返回boolean
    public  boolean Add(String s) {
        System.out.print("待办事项：");
        System.out.print(s+"\n");

        Content_list.add(s);
        Status_list.add("待完成");
        return true;
    }
    //修改状态--返回boolean
    public boolean Change_status(int index,boolean b) {
        if(index<=this.Content_list.size()&&index>0) {

                if (b) Status_list.set(index - 1, "已完成");
                else Status_list.set(index - 1, "待完成");
                System.out.printf("%d:修改完成\n", index);
                return true;
        }
        else
        {
            System.out.println("当前无修改项");
            return false;
        }
    }
    //打印当前所有目录--返回boolean
    public  void printnt(){
        int i;
        for(i=0;i<Content_list.size();i++) {
            System.out.printf("%d\n", i+1);
            System.out.println("内容： "+Content_list.get(i));
            System.out.println("属性： "+Status_list.get(i));
        }
    }

}