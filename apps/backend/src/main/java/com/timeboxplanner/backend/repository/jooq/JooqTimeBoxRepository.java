package com.timeboxplanner.backend.repository.jooq;

import com.timeboxplanner.backend.repository.TimeBoxRepository;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class JooqTimeBoxRepository implements TimeBoxRepository {
    private static final Table<?> TIME_BOX = DSL.table("time_box");
    private static final Field<LocalDate> START_DAY = DSL.field("date(start_at)", LocalDate.class);
    private static final Field<String> STATUS = DSL.field("status", String.class);
    private static final Field<Integer> DURATION_MINUTES = DSL.field(
        "coalesce((extract(epoch from (end_at - start_at)) / 60)::int, 0)",
        Integer.class
    );

    private final DSLContext dsl;

    public JooqTimeBoxRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public int countByDate(LocalDate date) {
        Record1<Integer> record = dsl
            .selectCount()
            .from(TIME_BOX)
            .where(START_DAY.eq(date))
            .fetchOne();
        return record == null ? 0 : record.value1();
    }

    @Override
    public int countDoneByDate(LocalDate date) {
        Record1<Integer> record = dsl
            .selectCount()
            .from(TIME_BOX)
            .where(START_DAY.eq(date))
            .and(STATUS.eq("DONE"))
            .fetchOne();
        return record == null ? 0 : record.value1();
    }

    @Override
    public int sumPlannedMinutesByDate(LocalDate date) {
        Integer value = dsl
            .select(DSL.sum(DURATION_MINUTES))
            .from(TIME_BOX)
            .where(START_DAY.eq(date))
            .fetchOne(0, Integer.class);
        return value == null ? 0 : value;
    }

    @Override
    public int sumDoneMinutesByDate(LocalDate date) {
        Integer value = dsl
            .select(DSL.sum(DURATION_MINUTES))
            .from(TIME_BOX)
            .where(START_DAY.eq(date))
            .and(STATUS.eq("DONE"))
            .fetchOne(0, Integer.class);
        return value == null ? 0 : value;
    }
}
