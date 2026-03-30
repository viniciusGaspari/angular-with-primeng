CREATE OR REPLACE FUNCTION create_permission_and_set_role()
RETURNS TRIGGER AS $$
DECLARE
    id_new_permission INTEGER;
BEGIN
    IF lower(TG_TABLE_NAME) = 'employees' THEN
        NEW.role_id := 1;
        INSERT INTO permissions (can_read, can_create, can_update, can_delete)
        VALUES (TRUE, FALSE, FALSE, FALSE)
        RETURNING permissions_id INTO id_new_permission;

    ELSIF lower(TG_TABLE_NAME) = 'companies' THEN
        NEW.role_id := 2;
        INSERT INTO permissions (can_read, can_create, can_update, can_delete)
        VALUES (TRUE, TRUE, TRUE, TRUE)
        RETURNING permissions_id INTO id_new_permission;

    ELSE
        INSERT INTO permissions (can_read, can_create, can_update, can_delete)
        VALUES (TRUE, FALSE, FALSE, FALSE)
        RETURNING permissions_id INTO id_new_permission;
    END IF;

    NEW.permissions_id := id_new_permission;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_permission_company
BEFORE INSERT ON companies
FOR EACH ROW
EXECUTE FUNCTION create_permission_and_set_role();

CREATE TRIGGER trg_permission_employee
BEFORE INSERT ON employees
FOR EACH ROW
EXECUTE FUNCTION create_permission_and_set_role()