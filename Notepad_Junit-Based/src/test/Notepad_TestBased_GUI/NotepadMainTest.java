package Notepad_TestBased_GUI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotepadMainTest
{
    NotepadMain m= new NotepadMain();


    @Test
    public void Check_New_Func()
    {
        assertTrue(m.NewFile(m));
    }
    @Test
    void Check_Open_File()
    {
        assertTrue(m.OpenFile(m),() ->" Couldnt Find File");
    }
    @Test
    public void Check_Save_Func()
    {
        assertTrue(m.SaveFile(m));
    }




    @Test
    public void Check_Cut_Func()
    {
        assertTrue(m.cut(m));
    }

    @Test
    public void Check_Copy_Func()
    {
        assertTrue(m.copy(m));
    }

    @Test
    public void Check_Paste_Func()
    {
        assertTrue(m.paste(m));
    }
    @Test
    public void Check_SelectALL_Func()
    {
        assertTrue(m.selectall(m));
    }
    @Test
    public void Check_Print_Func()
    {
        assertTrue(m.printfile(m));
    }
    @Test
    public void Check_About_Func()
    {

        assertInstanceOf(NotepadAbout.class,m.about(),()->"We didnt made correct assert");
    }

}