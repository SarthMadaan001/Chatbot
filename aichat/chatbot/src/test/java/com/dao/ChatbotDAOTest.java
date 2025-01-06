package com.dao;

import com.model.User;
import com.util.DatabaseUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

class ChatbotDAOTest {

    @Mock
    private DatabaseUtil mockDatabaseUtil;

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    private ChatbotDAO chatbotDAO;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        when(mockDatabaseUtil.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        chatbotDAO = new ChatbotDAO(mockDatabaseUtil);
    }

    @Test
    void testAddUser () throws SQLException {
        User user = new User("testUser ", "test@example.com");
        chatbotDAO.addUser (user);

        verify(mockPreparedStatement, times(1)).setString(1, "testUser ");
        verify(mockPreparedStatement, times(1)).setString(2, "test@example.com");
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }
}