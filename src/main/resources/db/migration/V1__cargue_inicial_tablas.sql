
CREATE TABLE patients (
                          pt_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                          pt_first_name VARCHAR(100) NOT NULL,
                          pt_last_name VARCHAR(100) NOT NULL,
                          pt_gender VARCHAR(20),
                          pt_birth_date DATE NOT NULL,
                          pt_nationality VARCHAR(100),
                          pt_address TEXT,
                          pt_phone_number VARCHAR(15),
                          pt_email VARCHAR(100),
                          pt_medical_info TEXT,
                          pt_profile_picture BLOB
);

CREATE TABLE categories (
                            ct_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                            ct_name VARCHAR(50) NOT NULL,
                            ct_description TEXT(255)
);

CREATE TABLE services (
                          sv_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                          sv_name VARCHAR(100) NOT NULL,
                          sv_description TEXT(255),
                          sv_cost DECIMAL(10, 2) NOT NULL
);

CREATE TABLE rooms (
                       rm_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                       rm_ct_id INTEGER NOT NULL,
                       rm_number CHAR(3) NOT NULL,
                       rm_floor INTEGER NOT NULL,
                       rm_quota INTEGER NOT NULL,
                       rm_cost DECIMAL(10, 2) NOT NULL,
                       rm_details TEXT(200),
                       rm_vacant TINYINT(1) NOT NULL,
                       FOREIGN KEY (rm_ct_id) REFERENCES categories(ct_id)
);

CREATE TABLE packages (
                          pk_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                          pk_name VARCHAR(100) NOT NULL,
                          pk_total_cost DECIMAL(10, 2) NOT NULL,
                          pk_days INTEGER NOT NULL,
                          pk_description TEXT(255) NOT NULL
);

CREATE TABLE guests (
                        gt_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                        gt_pt_id INTEGER NOT NULL,
                        gt_rm_id INTEGER NOT NULL,
                        gt_entry_date DATE NOT NULL,
                        gt_exit_date DATE NOT NULL,
                        FOREIGN KEY (gt_pt_id) REFERENCES patients(pt_id),
                        FOREIGN KEY (gt_rm_id) REFERENCES rooms(rm_id)
);

CREATE TABLE packages_services (
                                   pksv_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                   pksv_pk_id INTEGER NOT NULL,
                                   pksv_sv_id INTEGER NOT NULL,
                                   FOREIGN KEY (pksv_pk_id) REFERENCES packages(pk_id),
                                   FOREIGN KEY (pksv_sv_id) REFERENCES services(sv_id)
);

CREATE TABLE packages_patients (
                                   pkpt_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                   pkpt_pk_id INTEGER NOT NULL,
                                   pkpt_pt_id INTEGER NOT NULL,
                                   pkpt_purchase_date DATE NOT NULL,
                                   FOREIGN KEY (pkpt_pk_id) REFERENCES packages(pk_id),
                                   FOREIGN KEY (pkpt_pt_id) REFERENCES patients(pt_id)
);
