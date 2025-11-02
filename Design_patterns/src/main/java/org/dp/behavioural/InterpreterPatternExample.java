package org.dp.behavioural;

public class InterpreterPatternExample {
    public static void main(String[] args) {
        Context context = new Context();
        Interpreter interpreter = new Interpreter(context);
        System.out.println(interpreter.interpret("2+3 * 4"));
    }
}


class Context{
    // some logic that can be used via globally
}

interface Expression {
    int interpret(Context context);
}

class NumberExpression implements Expression{

    int number;
    public NumberExpression(int number){
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return  number;
    }
}

class AddExpression implements Expression{

    Expression expression1;
    Expression expression2;

    public AddExpression(Expression expression1,Expression expression2){
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public int interpret(Context context) {
        return expression1.interpret(context) + expression2.interpret(context);
    }
}

class MultiplyExpression implements Expression{
    Expression expression1;
    Expression expression2;

    public MultiplyExpression(Expression expression1, Expression expression2){
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public int interpret(Context context) {
        return expression1.interpret(context) * expression2.interpret(context);
    }
}

class Interpreter {

    Context context;

    public Interpreter(Context context) {
        this.context = context;
    }

    public int interpret(String expression){
        Expression resExpression = buildTreeofExpression(expression);
        return resExpression.interpret(context);
    }

    private Expression buildTreeofExpression(String expression) {
        // Assuming the input expression string is parsed.

        return new AddExpression(new NumberExpression(2),
                new MultiplyExpression(new NumberExpression(3) , new NumberExpression(4)));
    }

}
