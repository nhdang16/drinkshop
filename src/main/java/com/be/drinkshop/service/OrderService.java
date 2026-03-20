package com.be.drinkshop.service;

import com.be.drinkshop.dto.MonthlyRevenueDTO;
import com.be.drinkshop.dto.OrderDTO;
import com.be.drinkshop.dto.OrderRequest;
import com.be.drinkshop.dto.StatisticDTO;
import com.be.drinkshop.model.Order;
import com.be.drinkshop.model.enums.OrderStatus;
import jakarta.transaction.Transactional;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(Long id);

    @Transactional
    Order createOrder(OrderRequest orderRequest);

    Order updateOrder(Long id, Order orderDetails);

    void updateOrderStatus(Long id, OrderStatus status);

    void deleteOrder(Long id);

    List<OrderDTO> getOrdersByUserId(Long userId);

    StatisticDTO getOrderStats();

    StatisticDTO getMonthlyRevenue();

    List<MonthlyRevenueDTO> getMonthlyRevenueData(int year);
}
