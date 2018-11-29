package org.firstinspires.ftc.teamcode;


        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="9239 Main Teleop")

public class MainTeleop18 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    DcMotor leftDriveMotor = null;
    DcMotor rightDriveMotor = null;
    DcMotor armMotor = null;
    private double zero = 0.0;
    private double armSpeed = 0.1;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDriveMotor = hardwareMap.dcMotor.get("left drive motor");
        rightDriveMotor = hardwareMap.dcMotor.get("right drive motor");
        armMotor = hardwareMap.dcMotor.get("lift motor");

        leftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftDriveMotor.setDirection(DcMotor.Direction.FORWARD);
        rightDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        armMotor.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            leftDriveMotor.setPower(gamepad1.left_stick_y);
            rightDriveMotor.setPower(gamepad1.right_stick_y);

            if(gamepad1.a)
            {
                armMotor.setPower(armSpeed);
            }
            else if(gamepad1.b)
            {
                armMotor.setPower(-armSpeed);
            }
            else
            {
                armMotor.setPower(zero);
            }
        }
    }
}
