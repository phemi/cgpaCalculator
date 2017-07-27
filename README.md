CGPA Calculator helps in the computation of student's cummulative grade and print transcript.

![alt text](dashboard.png)


## Installation

### Requirements
    *Java: JDK >= 7
    *Database: Mysql >= 5.5

<br><br>

### How to install <br>
    *Clone Repo <br>
    *Run the sql dump compdept.sql <br>
    *Set Database configuration in src/Backhand/SunDB2.java <br>
```
     public final String url = "jdbc:mysql://localhost:3306/compdept";
        public final String userName = "root";
        public final String password = "";
        public String query= "SELECT * FROM `info2011_12`";
    ```

Run CgpaINterface.java <br>
Username: admin <br>
Password: admin <br>

## License

CGPA calculator is licensed under the [MIT license](https://opensource.org/licenses/MIT).


