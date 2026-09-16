# Delivery Service

A backend system for managing a delivery service.

## 📦 About the Project

**Delivery Service** is a pet project that simulates the business processes of a real delivery platform.

Customers create delivery orders, and available couriers can browse and choose deliveries that they want to complete.

The platform manages the entire delivery lifecycle — from creating an order to successfully delivering it to the customer.

---

## 🎯 Business Goal

The system connects three types of users:

* **Customer** — creates and tracks delivery orders.
* **Courier** — browses available deliveries and chooses which ones to complete.
* **Manager** — monitors the delivery operation and handles problematic orders.

A typical delivery looks like this:

```text
Customer
   ↓
Creates an order
   ↓
Order becomes available
   ↓
Courier browses available deliveries
   ↓
Courier accepts the delivery
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

* view available deliveries;
* view delivery details before accepting them;
* choose a delivery they want to complete;
* accept a delivery;
* view their active delivery;
* confirm that an order has been picked up;
* start the delivery;
* confirm successful delivery;
* report a failed delivery.

A courier can have one of the following states:

* **Available**
* **Busy**
* **Offline**

When a courier accepts a delivery, that delivery becomes unavailable to other couriers.

---

### Manager

A manager is responsible for monitoring the delivery operation.

A manager can:

* view all orders;
* view available deliveries;
* view active deliveries;
* view couriers;
* monitor courier activity;
* cancel orders when necessary;
* handle failed deliveries;
* resolve problematic situations;
* view order history.

The manager does **not** normally assign couriers to deliveries. Couriers choose deliveries themselves.

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
Available
   ↓
Accepted by Courier
   ↓
Picked Up
   ↓
In Transit
   ↓
Delivered
```

An order can also be cancelled or marked as undeliverable when something goes wrong.

```text
Created ─────────────→ Cancelled

Available ───────────→ Cancelled

Picked Up ───────────→ Delivery Failed
```

The exact rules for changing statuses are part of the business logic of the application.

---

# 🚚 Choosing a Delivery

When an order becomes available, nearby or available couriers can see it in the list of available deliveries.

For example:

```text
Available Deliveries

#152
Pickup: Magnum, Abaya 25
Delivery: Satpaev 10
Distance: 4.2 km
Price: 1,500 ₸

#153
Pickup: Small, Kazakhstan 15
Delivery: Krylova 8
Distance: 2.8 km
Price: 1,200 ₸

#154
Pickup: Restaurant
Delivery: Nezavisimosti 21
Distance: 6.1 km
Price: 2,000 ₸
```

The courier chooses a delivery based on the information available to them.

Once the courier accepts an order:

```text
Available
    ↓
Accepted
    ↓
Courier: Alex
```

The order is no longer available to other couriers.

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
* make the delivery available again;
* contact the customer;
* take another appropriate action.

---

# 📝 Order History

The system keeps a history of important events related to an order.

For example:

```text
10:02 — Order created
10:05 — Order confirmed
10:12 — Order became available
10:18 — Courier Alex accepted the delivery
10:31 — Order picked up
10:45 — Delivery started
11:02 — Order delivered
```

This allows the company to understand what happened to an order and when.

---

# 🔐 Business Rules

The system must enforce rules such as:

* A customer can only manage their own orders.
* A courier can only manage deliveries they have accepted.
* A courier cannot accept a delivery that has already been accepted by another courier.
* A courier cannot accept a new delivery while they are busy with another one.
* A delivered order cannot be cancelled.
* A courier cannot start delivery before picking up the order.
* Only available deliveries can be accepted by couriers.
* A courier must be available before accepting a delivery.
* Payment status must be consistent with the order state.

Additional business rules may be introduced during development.

---

# 📌 Example Scenario

A customer orders groceries from a store.

```text
1. Customer creates an order.

2. The company confirms the order.

3. The order becomes available to couriers.

4. Several couriers can see the delivery.

5. Alex decides to accept the delivery.

6. The delivery is immediately assigned to Alex.

7. Other couriers can no longer accept it.

8. Alex picks up the groceries.

9. Alex starts the delivery.

10. Alex delivers the order.

11. The order is marked as delivered.
```

If Alex cannot complete the delivery, the system records the problem and the manager can decide whether the order should be cancelled or made available to another courier.

---

# 📈 Future Features

The platform may later support:

* showing deliveries based on courier location;
* estimated distance and travel time;
* courier earnings;
* delivery history;
* customer ratings;
* courier ratings;
* surge pricing;
* scheduled deliveries;
* promo codes;
* delivery zones;
* multiple stores;
* notifications;
* real-time courier tracking;
* analytics and reports.
