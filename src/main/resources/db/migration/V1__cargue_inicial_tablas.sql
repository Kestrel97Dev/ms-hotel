CREATE TABLE Patients (
                          pt_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                          pt_first_name TEXT(100) NOT NULL,
                          pt_last_name TEXT(100) NOT NULL,
                          pt_gender TEXT(20),
                          pt_birth_date TEXT(10) NOT NULL,
                          pt_nationality TEXT(100),
                          pt_address TEXT,
                          pt_phone_number TEXT(10),
                          pt_email TEXT(100),
                          pt_medical_info TEXT,
                          pt_profile_picture BLOB
);

CREATE TABLE Categories (
                            ct_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                            ct_name TEXT(50) NOT NULL,
                            ct_description TEXT(255)
);

CREATE TABLE Services (
                          sv_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                          sv_name TEXT(100) NOT NULL,
                          sv_description TEXT(255),
                          sv_cost REAL NOT NULL
);

CREATE TABLE Rooms (
                       rm_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                       rm_ct_id INTEGER NOT NULL,
                       rm_number TEXT(3) NOT NULL,
                       rm_floor INTEGER NOT NULL,
                       rm_quota INTEGER NOT NULL,
                       rm_cost REAL NOT NULL,
                       rm_details TEXT(200),
                       rm_vacant INTEGER NOT NULL,
                       FOREIGN KEY (rm_ct_id) REFERENCES Categories(ct_id)
);

CREATE TABLE Packages (
                          pk_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                          pk_name TEXT(100) NOT NULL,
                          pk_total_cost INTEGER NOT NULL,
                          pk_days INTEGER NOT NULL,
                          pk_description TEXT(255) NOT NULL
);

CREATE TABLE Guests (
                        gt_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                        gt_pt_id TEXT(10) NOT NULL,
                        gt_rm_id TEXT(10) NOT NULL,
                        gt_entry_date DATE NOT NULL,
                        gt_exit_date DATE NOT NULL
);

CREATE TABLE Packages_Services (
                                   pksv_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                   pksv_pk_id INTEGER NOT NULL,
                                   pksv_sv_id INTEGER NOT NULL,
                                   FOREIGN KEY (pksv_pk_id) REFERENCES Packages(pk_id),
                                   FOREIGN KEY (pksv_sv_id) REFERENCES Services(sv_id)
);

CREATE TABLE Packages_Patients (
                                   pkpt_id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                   pkpt_pk_id INTEGER NOT NULL,
                                   pkpt_pt_id INTEGER NOT NULL,
                                   pkpt_purchase_date DATE NOT NULL,
                                   FOREIGN KEY (pkpt_pk_id) REFERENCES Packages(pk_id),
                                   FOREIGN KEY (pkpt_pt_id) REFERENCES Patients(pt_id)
);
