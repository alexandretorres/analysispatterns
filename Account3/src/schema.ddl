
    create table Account (
        number int4 not null,
        primary key (number)
    );

    create table Act_Brief (
        dt_calc date,
        value float8,
        UNIT varchar(255),
        number int4 not null,
        primary key (number)
    );

    create table Act_Comps (
        summary_number int4 not null,
        components_number int4 not null
    );

    create table DetailAccount (
        number int4 not null,
        primary key (number)
    );

    create table Entry (
        ACCT_NUMBER int4,
        ID_TRANSACTION int8,
        amount float8 not null,
        UNIT varchar(255),
        primary key (ACCT_NUMBER, ID_TRANSACTION)
    );

    create table SummaryAccount (
        number int4 not null,
        primary key (number)
    );

    create table Transaction (
        ID_TRANSACTION  bigserial not null,
        dt_transaction date,
        primary key (ID_TRANSACTION)
    );

    create table Unit (
        Unit varchar(255) not null,
        primary key (Unit)
    );

    alter table Act_Brief 
        add constraint FK6FBB3E4D3E842A49 
        foreign key (UNIT) 
        references Unit;

    alter table Act_Brief 
        add constraint FK6FBB3E4DB48C1A95 
        foreign key (number) 
        references Account;

    alter table Act_Comps 
        add constraint FK6FC80917B1780FDE 
        foreign key (components_number) 
        references Account;

    alter table Act_Comps 
        add constraint FK6FC80917611937AA 
        foreign key (summary_number) 
        references SummaryAccount;

    alter table DetailAccount 
        add constraint FK2B756C7CB48C1A95 
        foreign key (number) 
        references Account;

    alter table Entry 
        add constraint FK40018523E842A49 
        foreign key (UNIT) 
        references Unit;

    alter table Entry 
        add constraint FK40018521011F370 
        foreign key (ACCT_NUMBER) 
        references DetailAccount;

    alter table Entry 
        add constraint FK400185292864E37 
        foreign key (ID_TRANSACTION) 
        references Transaction;

    alter table SummaryAccount 
        add constraint FKB5957FC7B48C1A95 
        foreign key (number) 
        references Account;

    create sequence ACCT_SEQUENCE;
