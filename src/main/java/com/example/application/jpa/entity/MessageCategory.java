package com.example.application.jpa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "message_categories")
public class MessageCategory {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("result")
    @Column(name = "title")
    private String title;

//    request,
//    cancel_order,
//    change_order,
//    change_shipping_address,
//    check_cancellation_fee,
//    check_invoice,
//    check_invoices,
//    check_payment_methods,
//    check_refund_policy,
//    complaint,
//    contact_customer_service,
//    contact_human_agent,
//    create_account,
//    delete_account,
//    delivery_options,
//    delivery_period,
//    edit_account,
//    get_invoice,
//    get_refund,
//    newsletter_subscription,
//    payment_issue,
//    place_order,
//    recover_password,
//    registration_problems,
//    review,
//    set_up_shipping_address,
//    switch_account,
//    track_order,
//    track_refund,
}
