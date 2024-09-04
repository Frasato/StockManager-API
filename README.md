# Stock Manager API
<p>An API to manage a stock of a business, can create itens, read all of them, search for name, bac code, item or mark.</p>

### technologies used

<p>I use Java 21 with my principal language, using spring boot framework to create Rest API's and postgreSQL for create database.</p>

- Java 21
- Spring Boot
- PostgreSQL

<hr>

### End Points

Send all request to this path:

``/itens``

<p>To create new itens on table you can use:</p>

``/create``

<p>You have to send a body to this endpoint to create a item o table.
This body may have some informations:</p>

- ``long`` barCode
- ``String`` itemName
- ``String`` markName
- ``int`` amount

<p>To actualize itens to inserto into the table, use:</p>

``/update/{id}``

<p>You have to pass the id to URL and a json body 
for information you whant to change, with same iformation you pass to create
an item.</p>

<p>To take out an item for stock, you have to use this end point:</p>

``/takeout/{id}``

<p>Informal how many itens do you whant to take out of stock, where do you take out
and what is the sector the item will go.</p>

<p>And more and more end points you can use to make your application.</p>

<hr>
<p>To search end point I create a custom slq code.</p>

```java
@Query(value = "SELECT * FROM itens_tb WHERE CAST(bar_code AS CHAR)" +
        "LIKE %:searchItem% OR item LIKE %:searchItem% OR mark LIKE %:searchItem%",
        nativeQuery = true)
List<ActiveItensModel> findByBarCodeItemNameMarkName(@Param("searchItem") String searchItem);
```
<hr>

<h4>Front End</h4>
::hammer:: in work!