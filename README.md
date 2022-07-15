# Medical Agenda - Logus Retail - API #

## ENDPOINTS ##

### GET ###
/schedules 
/schedules?date='2021-08-17'
/schedules?patient_name=Kelvin%20Ribeiro
/schedules?patient_id=1&date=2020-12-11
/schedules/{id}
/doctors/{id}
/patients/{id}

POST

/patients
```
{
    "name": "Johnny Mendes Santana Ribeiro",
}
```
/doctors
```
{
    "name": "Felipe Xpto da Silva",
    "doctorCRM" : "CRM/SP 123456",
}
```

/schedules
```
{
    "patient": {
        "id" : 1
    },
    "doctor": {
        "id": 2
    },
    "scheduleDate": "2020-11-12",
    "scheduleTime": "13:47:00",
    "clinicNumber": 123456
}
```