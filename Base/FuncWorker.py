from Objects import Worker
from Storage import WorkerRepo
import Functions

class Functions_worker:
    def __register_worker():
        name = input("\nWorker's name: ")
        last_name = input("\nWorker's last name: ")
        print("\nWorker's birthday: ")
        birthday = Functions.Functions.__set_date()
        print("\nSet date of register: ")
        reg_date = Functions.Functions.__set_date()
        curp = input("\nWorker's CURP: ")
        rfc = input("\nWorker's RFC: ")
        wage = input("\nWorker's wage: ")
        schedule = input("\nWorker's schedule: ")
        role = set_role()
    
        worker = Worker.Worker(name, last_name, birthday, curp, reg_date, rfc, wage, schedule, role)
        WorkerRepo.Workers.worker_list.add(worker)

    def __modify_worker():
        