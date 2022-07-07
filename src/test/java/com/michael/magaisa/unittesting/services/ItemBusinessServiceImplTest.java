package com.michael.magaisa.unittesting.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.michael.magaisa.unittesting.model.Item;
import com.michael.magaisa.unittesting.model.ItemRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ItemBusinessServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ItemBusinessServiceImplTest {
    @Autowired
    private ItemBusinessServiceImpl itemBusinessServiceImpl;

    @MockBean
    private ItemRepository itemRepository;

    /**
     * Method under test: {@link ItemBusinessServiceImpl#retrieveHardCodedItem()}
     */
    @Test
    void testRetrieveHardCodedItem() {
        Item actualRetrieveHardCodedItemResult = itemBusinessServiceImpl.retrieveHardCodedItem();
        assertEquals(1, actualRetrieveHardCodedItemResult.getId());
        assertEquals(11, actualRetrieveHardCodedItemResult.getQuantity());
        assertEquals(1250, actualRetrieveHardCodedItemResult.getPrice());
        assertEquals("MacBook Pro 2020 M1 Chip", actualRetrieveHardCodedItemResult.getName());
    }

    /**
     * Method under test: {@link ItemBusinessServiceImpl#getAllItems()}
     */
    @Test
    void testGetAllItemsUsingDataServiceEmptyList() {
        ArrayList<Item> itemList = new ArrayList<>();
        when(itemRepository.findAll()).thenReturn(itemList);
        List<Item> actualAllItems = itemBusinessServiceImpl.getAllItems();
        assertSame(itemList, actualAllItems);
        assertTrue(actualAllItems.isEmpty());
        verify(itemRepository).findAll();
    }

    @Test
    void testGetAllItemsUsingDataServiceWithFilledList(){

        when(itemRepository.findAll()).thenReturn(Arrays.asList(
                new Item(10002, "MacBook Pro M1 Chip", 1300, 7),
                new Item(10003, "MacBook Air M1 Chip", 1250, 14)
        ));

        List<Item> actualItemsList = itemRepository.findAll();

        assertEquals(10002, actualItemsList.get(0).getId());
        assertEquals("MacBook Air M1 Chip", actualItemsList.get(1).getName());
        assertFalse(actualItemsList.isEmpty());
        verify(itemRepository).findAll();
    }
}

