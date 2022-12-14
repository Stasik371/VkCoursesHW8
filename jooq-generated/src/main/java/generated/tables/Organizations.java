/*
 * This file is generated by jOOQ.
 */
package generated.tables;


import generated.Keys;
import generated.Public;
import generated.tables.records.OrganizationsRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function1;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row1;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Organizations extends TableImpl<OrganizationsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.organizations</code>
     */
    public static final Organizations ORGANIZATIONS = new Organizations();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrganizationsRecord> getRecordType() {
        return OrganizationsRecord.class;
    }

    /**
     * The column <code>public.organizations.name</code>.
     */
    public final TableField<OrganizationsRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR.nullable(false), this, "");

    private Organizations(Name alias, Table<OrganizationsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Organizations(Name alias, Table<OrganizationsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.organizations</code> table reference
     */
    public Organizations(String alias) {
        this(DSL.name(alias), ORGANIZATIONS);
    }

    /**
     * Create an aliased <code>public.organizations</code> table reference
     */
    public Organizations(Name alias) {
        this(alias, ORGANIZATIONS);
    }

    /**
     * Create a <code>public.organizations</code> table reference
     */
    public Organizations() {
        this(DSL.name("organizations"), null);
    }

    public <O extends Record> Organizations(Table<O> child, ForeignKey<O, OrganizationsRecord> key) {
        super(child, key, ORGANIZATIONS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<OrganizationsRecord> getPrimaryKey() {
        return Keys.ORGANIZATIONS_PK;
    }

    @Override
    public Organizations as(String alias) {
        return new Organizations(DSL.name(alias), this);
    }

    @Override
    public Organizations as(Name alias) {
        return new Organizations(alias, this);
    }

    @Override
    public Organizations as(Table<?> alias) {
        return new Organizations(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Organizations rename(String name) {
        return new Organizations(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Organizations rename(Name name) {
        return new Organizations(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Organizations rename(Table<?> name) {
        return new Organizations(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row1 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function1<? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function1<? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
