# Delivery Service

A backend system for managing a delivery service.

## 📦 About the Project

**Delivery Service** is a pet project that simulates the business processes of a real delivery company.

The company accepts delivery orders from customers, assigns couriers to those orders, tracks the delivery process, and handles successful and failed deliveries.

The main goal of the project is to model the business processes of a delivery service and build a system around them.

---

## 🎯 Business Goal

The system connects three types of users:

* **Customer** — creates and tracks delivery orders.
* **Courier** — receives assigned orders and delivers them.
* **Manager** — manages orders and couriers and handles delivery issues.

A typical delivery looks like this:

```text
Customer
   ↓
Creates an order
   ↓
Order is confirmed
   ↓
Manager assigns a courier
   ↓
Courier picks up the order
   ↓
Courier delivers the order
   ↓
Customer receives the order
   ↓
Order is completed
```

---

## 👥 User Roles

### Customer

A customer can:

* create a delivery order;
* view their orders;
* view order details;
* track the current delivery status;
* cancel an order before delivery has started;
* see the delivery price;
* choose a payment method.

---

### Courier

A courier can:

* view orders assigned to them;
* accept a delivery;
* confirm that an order has been picked up;
* start the delivery;
* confirm successful delivery;
* report a failed delivery;
* provide a reason when a delivery cannot be completed.

A courier can have one of the following states:

* **Available**
* **Busy**
* **Offline**

---

### Manager

A manager is responsible for the day-to-day operation of the delivery service.

A manager can:

* view all orders;
* view all couriers;
* assign couriers to orders;
* cancel orders;
* monitor active deliveries;
* handle failed deliveries;
* reassign orders when necessary;
* view the history of orders.

---

# 📋 Orders

An order contains information about:

* customer;
* pickup address;
* delivery address;
* contact information;
* delivery time;
* delivery price;
* payment method;
* payment status;
* current order status;
* assigned courier.

### Order Lifecycle

A normal order follows this lifecycle:

```text
Created
   ↓
Confirmed
   ↓
Courier Assigned
   ↓
Picked Up
   ↓
In Transit
   ↓
Delivered
```

An order can also be cancelled or marked as undeliverable when something goes wrong.

```text
Created ─────────→ Cancelled

Picked Up ───────→ Delivery Failed
```

The exact rules for changing statuses are part of the business logic of the application.

---

# 💰 Delivery Pricing

The company charges customers for delivery.

The delivery price is calculated based on the characteristics of the order.

For example:

```text
Base delivery price     1,000 ₸
Express delivery          500 ₸
------------------------------
Total                   1,500 ₸
```

The pricing rules may be expanded as the project evolves.

---

# 💳 Payments

The system supports different payment methods:

* Cash
* Card

The project does not process real payments.

Instead, it keeps track of the payment state of an order:

* **Pending**
* **Paid**
* **Payment Failed**
* **Refunded**

---

# ⚠️ Failed Deliveries

A delivery may fail for different reasons.

For example:

> The courier arrives at the pickup location, but the required item is unavailable.

The courier reports the problem and provides a reason.

The manager can then decide what to do:

* cancel the order;
* assign another courier;
* contact the customer;
* take another appropriate action.

---

# 📝 Order History

The system keeps a history of important events related to an order.

For example:

```text
10:02 — Order created
10:05 — Order confirmed
10:12 — Courier assigned: Alex
10:25 — Order picked up
10:42 — Delivery started
10:58 — Order delivered
```

This allows the company to understand what happened to an order and when.

---

# 🔐 Business Rules

The system must enforce rules such as:

* A customer can only manage their own orders.
* A courier can only update orders assigned to them.
* A courier cannot accept an order that is already assigned to another courier.
* A delivered order cannot be cancelled.
* A courier cannot start delivery before picking up the order.
* An order cannot be assigned to an unavailable courier.
* Payment status must be consistent with the order state.

Additional business rules may be introduced during development.

---

# 🚀 Project Scope

The project is intentionally designed to grow over time.

### Initial version

The first version will focus on:

* customers;
* couriers;
* managers;
* orders;
* order statuses;
* courier assignment;
* delivery pricing;
* payments;
* order history.

### Possible future features

The system may later include:

* real-time delivery tracking;
* courier location;
* estimated delivery time;
* notifications;
* customer reviews;
* promo codes;
* delivery zones;
* multiple stores;
* scheduled deliveries;
* analytics and reports;
* courier performance statistics.

---

# 🏗️ Development Approach

The project is being developed as a simulation of a real-world delivery service.

The business requirements are defined first, and the technical implementation is derived from those requirements.

The project will evolve as new business cases and requirements are introduced.

---

## 📌 Example Scenario

A customer orders groceries from a store.

```text
1. Customer creates an order.

2. The company confirms the order.

3. A manager sees that the order needs a courier.

4. The manager assigns an available courier.

5. The courier receives the order.

6. The courier picks up the groceries.

7. The courier starts the delivery.

8. The courier delivers the order.

9. The customer receives the order.

10. The order is marked as delivered.
```

If the courier cannot pick up the order, the delivery is marked as failed and the manager handles the situation.

---

## 📚 Project Purpose

This project is built as a **Java/Spring Boot backend pet project** to practice designing and implementing a business-oriented application.

The focus is not only on creating CRUD operations, but on representing real business processes, rules, and interactions between different users of the system.

---

## 📈 Status

**In development 🚧**

The project is being developed incrementally, starting with the core delivery workflow and expanding toward a more complete delivery management system.
