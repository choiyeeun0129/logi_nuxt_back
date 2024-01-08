package kr.co.seoulit.erp.logistic.base.dao;

import kr.co.seoulit.erp.logistic.base.to.ItemTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemDAOTest {

    @Autowired
    ItemDAO itemDAO;

    @Test
    public void test(){
        System.out.println("<<<<<<<<<< itemDAO = " + itemDAO);
    }

    @Test
    public void selectTest(){
        ArrayList<ItemTO> list =itemDAO.searchItemList();
        assertTrue(list.size()!=0);
        System.out.println("<<<<<<<<<<<<<<<<< list = " + list);
    }


}