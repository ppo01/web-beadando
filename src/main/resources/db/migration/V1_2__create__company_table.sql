create table beadando.company(
    company_id bigint identity(1,1) primary key,
    company_name nvarchar(255) not null,
    address nvarchar(255) not null,
    main_activity nvarchar(255) not null

);

