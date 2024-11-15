INSERT INTO patients (pt_first_name, pt_last_name, pt_gender, pt_birth_date, pt_nationality, pt_address, pt_phone_number, pt_email, pt_medical_info, pt_profile_picture)
VALUES
    ('Juan', 'Pérez', 'Masculino', '1980-05-15', 'Colombiana', 'Calle 123', '3001234567', 'juan.perez@example.com', 'Sin alergias', NULL),
    ('María', 'López', 'Femenino', '1992-07-21', 'Mexicana', 'Avenida Reforma', '5509876543', 'maria.lopez@example.com', 'Diabetes tipo 2', NULL),
    ('Carlos', 'Martínez', 'Masculino', '1985-10-10', 'Argentina', 'Calle Corrientes', '5412345678', 'carlos.martinez@example.com', 'Hipertensión', NULL);

INSERT INTO categories (ct_name, ct_description)
VALUES
    ('Habitación Estándar', 'Habitación sencilla con baño privado y WiFi'),
    ('Suite Ejecutiva', 'Habitación de lujo con sala de estar y vistas al mar'),
    ('Habitación Doble', 'Habitación con dos camas individuales y baño privado');

INSERT INTO services (sv_name, sv_description, sv_cost)
VALUES
    ('Desayuno', 'Desayuno continental incluido', 15.00),
    ('Servicio de Spa', 'Acceso al spa durante 2 horas', 50.00),
    ('Transporte al Aeropuerto', 'Servicio de traslado desde y hacia el aeropuerto', 30.00);

INSERT INTO rooms (rm_ct_id, rm_number, rm_floor, rm_quota, rm_cost, rm_details, rm_vacant)
VALUES
    (1, '101', 1, 2, 50.00, 'Habitación con vista al jardín', 1),
    (2, '202', 2, 3, 150.00, 'Suite con jacuzzi y balcón', 1),
    (3, '303', 3, 4, 75.00, 'Habitación doble con minibar', 0);

INSERT INTO packages (pk_name, pk_total_cost, pk_days, pk_description)
VALUES
    ('Paquete Vacacional', 300, 3, 'Paquete de estadía con desayuno incluido'),
    ('Escapada Romántica', 500, 2, 'Paquete para parejas con cena y spa'),
    ('Aventura Familiar', 700, 5, 'Paquete para familias con actividades y tours incluidos');

INSERT INTO guests (gt_pt_id, gt_rm_id, gt_entry_date, gt_exit_date)
VALUES
    (1, 1, '2024-12-01', '2024-12-04'),
    (2, 2, '2024-12-05', '2024-12-08'),
    (3, 3, '2024-12-10', '2024-12-15');

INSERT INTO packages_services (pksv_pk_id, pksv_sv_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

INSERT INTO packages_patients (pkpt_pk_id, pkpt_pt_id, pkpt_purchase_date)
VALUES
    (1, 1, '2024-11-13'),
    (2, 2, '2024-11-14'),
    (3, 3, '2024-11-15');
