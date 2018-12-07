package org.firstinspires.ftc.teamcode;


        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.util.ElapsedTime;
        import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="9239 Main Teleop")

public class MainTeleop18 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDriveMotor = null;
    private DcMotor rightDriveMotor = null;
    private DcMotor armMotor = null;
    private Servo scoop = null;
    private double zero = 0.0;
    private double armSpeed = 0.25;
    private double servoPosition = 0.0;
    static final double INCREMENT   = 0.01;     // amount to slew servo each CYCLE_MS cycle
    static final int    CYCLE_MS    =  10;      // period of each cycle
    static final double MAX_POS     =  1.0;     // Maximum rotational position
    static final double MIN_POS     =  0.0;     // Minimum rotational position


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDriveMotor = hardwareMap.dcMotor.get("left drive motor");
        rightDriveMotor = hardwareMap.dcMotor.get("right drive motor");
        armMotor = hardwareMap.dcMotor.get("lift motor");
        scoop = hardwareMap.servo.get("scoop");

        leftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftDriveMotor.setDirection(DcMotor.Direction.FORWARD);
        rightDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        armMotor.setDirection(DcMotor.Direction.FORWARD);

        scoop.setPosition(0);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            leftDriveMotor.setPower(gamepad1.left_stick_y);
            rightDriveMotor.setPower(gamepad1.right_stick_y);

            if(gamepad1.a)
            {
                armMotor.setPower(-armSpeed);
            }
            else if(gamepad1.b)
            {
                armMotor.setPower(armSpeed);
            }
            else
            {
                armMotor.setPower(zero);
            }

            if(gamepad1.x)
            {
                if(servoPosition > (MIN_POS+INCREMENT))
                {
                    servoPosition -= INCREMENT;
                }
            }
            else if(gamepad1.y)
            {
                if(servoPosition < (MAX_POS-INCREMENT))
                {
                    servoPosition += INCREMENT;
                }
            }

            scoop.setPosition(servoPosition);
            sleep(CYCLE_MS);
            idle();
        }
    }
}
