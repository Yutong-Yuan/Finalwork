package NoteBook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class noteTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束");
    }


//添加事项
    @Test
    public void add() {
        note note0 = new note();
        boolean addsuccess = note0.Add("四点约了汉克打球");
        assertTrue(addsuccess);
        assertEquals("四点约了汉克打球",note0.Content_list.get(note0.Content_list.size()-1));
        assertEquals("待完成",note0.Status_list.get(note0.Status_list.size()-1));
    }
//持续删除事项
    @Test
    public void deleteconsistently() {
        note note1 = new note();
        note1.Add("四点约了汉克打球");
        note1.Add("六点要到图书馆借一本书-《安徒生童话》");
        note1.Add("九点约了凯瑟琳一起去操场跑步");
        int length = note1.Content_list.size();
        boolean deletesuccess;
        int i;
        for(i=length;i>0;i--)
        {
            deletesuccess = note1.Delete(i);
            assertTrue(deletesuccess);
            assertEquals(--length,note1.Content_list.size());
        }
        assertFalse(note1.Delete(i));
        assertEquals(0,note1.Content_list.size());
    }
//持续改变事项
    @Test
    public void change_statusconsistently() {
        note note2 = new note();
        note2.Add("四点约了汉克打球");
        note2.Add("六点要到图书馆借一本书-《安徒生童话》");
        note2.Add("九点约了凯瑟琳一起去操场跑步");
        int length = note2.Content_list.size();
        int i;
        for(i=1;i<=length;i++)
        {
            note2.Change_status(i,false);
            assertEquals("待完成",note2.Status_list.get(i-1));
        }
        for(i=length;i>0;i--)
        {
            note2.Change_status(i,true);
            assertEquals("已完成",note2.Status_list.get(i-1));
        }
    }
    //修改不存在的事项
    @Test
    public void change_an_unexistone(){
        note note3 = new note();
        boolean ischange = note3.Change_status(0,true);
        assertFalse(ischange);

    }

}