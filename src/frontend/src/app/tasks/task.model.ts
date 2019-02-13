export class Task {
  public id:number;
  public name:string;
  public completed:boolean;
  public dueDate:string;


  constructor(  name: string, completed: boolean, dueDate: string, id ?: number /*id is nullable*/) {
    this.name = name;
    this.completed = completed;
    this.dueDate = dueDate;
    this.id = id;
  }



}
