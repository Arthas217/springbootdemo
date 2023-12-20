package com.burning.springboot.cassadra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetSocketAddress;
import java.time.Instant;
import java.time.LocalDate;

/**
 * @author 会游泳的蚂蚁
 * @date 2023/12/20 20:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CassadraTest {

    @Autowired
    CqlSession cqlSession;

    @Before
    public void init(){
        cqlSession = CqlSession.builder().
                addContactPoint(new InetSocketAddress("localhost",9042)).
                withKeyspace("msxf").
                withLocalDatacenter("datacenter1").build();
    }

    @Test
    public void testSelect() {
        PreparedStatement prepare = cqlSession.prepare("select * from emp where emp_id=?");
        BoundStatement bind = prepare.bind(1);
        ResultSet resultSet = cqlSession.execute(bind);
        for (Row row : resultSet) {
            LocalDate borndate = row.getLocalDate("borndate");
            Instant createDate = row.getInstant("create_date");
            int empId = row.getInt("emp_Id");
            System.out.println(borndate);
            System.out.println(createDate);
            System.out.println(empId);
        }
    }

}
