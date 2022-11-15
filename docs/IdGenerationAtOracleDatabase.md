
# jpa configure id Oracle

- oracle database support sequence objects
- a strategy of sequence indicates that a database sequence should be used to generate the identifier
- topLink will create a default sequence object during schema generation

```java
@Entity 
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

}

```

#### sequence object already exist in the database

- specify the allocation size to match the increment value of the 
database sequence object if it's defined to increment by 5 set the allocation size to 5
```java
@Entity
public class Inventory implements Serializable {
    
    @Id 
    @GeneratedValue(generator="InvSeq") 
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=5)
    private long id;
}
```



## Notes
- SQL Server database use identity column `@GeneratedValue(strategy=GenerationType.TABLE) `
