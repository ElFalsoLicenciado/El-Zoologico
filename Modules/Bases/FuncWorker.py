from ..Objects import Worker
from ..Storage import WorkerRepo
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
        role = Functions_worker.__set_role()
    
        worker = Worker.Worker(name, last_name, birthday, curp, reg_date, rfc, wage, schedule, role)
        WorkerRepo.Workers.worker_list.add(worker)

    def __modify_worker():
        if not WorkerRepo.Workers.worker_list:
            print("There's no workers registered.")
        else:
            cl = 0
            while cl<= 0 or cl > len(WorkerRepo.Workers.worker_list):
                Functions.Functions.__show_slaves()   
                cl = input("Select a worker: ")
                if  cl> 0 and cl <= len(WorkerRepo.Workers.worker_list):
                    break
                else:    
                    print("Invalid input")
            c = 0
            while True:
                while True:
                    print("\n1. Change ID\n2.Change full name\n3.Change birthday\n4.Change date of registry\n5.Change CURP\n6.Change RFC\n7.Change wage\n8.Change schedule\n9.Change role\n0. Return")
                    c = input("Input: ")
                    if c == 0:
                        break
                    elif c == 1:
                        Worker.Worker.__set_id(WorkerRepo.Workers.worker_list[cl-1])
                        print("\nNew ID: " + Worker.Worker.__get_id(WorkerRepo.Workers.worker_list[cl-1]))
                        break
                    elif c == 2:
                        name = input("\nWorker's new name: ")
                        last_name = input("\nWorker's new last name: ")
                        Worker.Worker.__set_name(WorkerRepo.Workers.worker_list[cl-1], name, last_name)
                        break
                    elif c== 3:
                        print("Worker's new birthday: ")
                        birthday = Functions.Functions.__set_date()
                        Worker.Worker.__set_birthday(WorkerRepo.Workers.worker_list[cl-1], birthday)
                        break
                    elif c == 4:
                        print("Workers's new registry date: ")
                        reg_date = Functions.Functions.__set_date()
                        Worker.Worker.__set_date_of_register(WorkerRepo.Workers.worker_list[cl-1], reg_date)
                        break
                    elif c == 5:
                        curp = input("\nWorkers's new curp: ")
                        Worker.Worker.__set_curp(WorkerRepo.Workers.worker_list[cl-1], curp)
                        break
                    elif c == 6:
                        rfc = input("Workers's new RFC: ")
                        Worker.Worker.__set_rfc(WorkerRepo.Workers.worker_list[cl-1], rfc)
                        break
                    elif c == 7:
                        wage = 0
                        while wage <= 0:
                            wage = input("Workers's new wage: ")
                            if wage>0:
                                Worker.Worker.__set_wage(WorkerRepo.Workers.worker_list[cl-1], wage)
                            else:
                                print("Invalid input")
                        break
                    elif c == 8:
                        schedule = input("Workers's new schedule: ")
                        Worker.Worker.__set_schedule(WorkerRepo.Workers.worker_list[cl-1], schedule)
                        break
                    elif c == 9:
                        print("Workers's new RFC: ")
                        role = Functions_worker.__set_role()
                        Worker.Worker.__set_role(WorkerRepo.Workers.worker_list[cl-1], role)
                        break
                    else:
                        print("Invalid input.")

    def __remove_worker():
        if not WorkerRepo.Workers.worker_list:
            print("There are no workers registered.")
        else:
            cl = 0
            while cl<= 0 or cl > len(WorkerRepo.Workers.worker_list):
                Functions.Functions.__show_slaves()   
                cl = input("Select a worker: ")
                if  cl> 0 and cl <= len(WorkerRepo.Workers.worker_list):
                    del WorkerRepo.Workers.worker_list[cl-1]
                else:    
                    print("Invalid input")
    
    def __set_role():
        r = 0
        while True:
            r = input("\nSelect a role: \nTechnician.\nGuide.\nAdministrator.\nVeterinary.")
            if r == 1:
                role = "Technician"
                break
            elif r == 2:
                role = "Guide"
                break
            elif r == 3:
                role = "Administrator"
                break
            elif r == 4:
                role = "Veterinary"
                break
            else:
                print("Invalid input")
        return role